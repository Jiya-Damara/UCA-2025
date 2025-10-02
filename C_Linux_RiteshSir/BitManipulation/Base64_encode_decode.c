#include <stdio.h>
#include <string.h>

static const char base64_table[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

// A reverse lookup table for decoding
static int decoding_table[256];

// Function to build the reverse lookup table
void build_decoding_table() {
  for (int i = 0; i < 256; i ++) decoding_table[i] = -1;
  for(int i = 0; i < 64; i++) decoding_table[(unsigned char) base64_table[i]] = i;
}

void base64_encode(const unsigned char *input, int len, char *output) {
  int i = 0, j = 0;
  size_t i_max = len - (len % 3); // We take out the maximum length of the string that is the multiple of three

  // Process full chunks
  for (i; i < i_max; i += 3) {
    unsigned int triple = (input[i] << 16) | (input[i + 1] << 8) | input[i + 2];
    output[j++] = base64_table[(triple >> 18) & 0x3F];
    output[j++] = base64_table[(triple >> 12) & 0x3F];
    output[j++] = base64_table[(triple >> 6) & 0x3F];
    output[j++] = base64_table[triple & 0x3F];
  }

  // Handle the remaining 1 or 2 bytes and add padding
  if (len % 3 == 1) {
    unsigned int triple = input[i] << 16;
    output[j++] = base64_table[(triple >> 18) & 0x3F];
    output[j++] = base64_table[(triple >> 12) & 0x3F];
    output[j++] = '=';
    output[j++] = '=';
  } else if (len % 3  == 2) {
    unsigned int triple = (input[i] << 16) | (input[i + 1] << 8);
    output[j++] = base64_table[(triple >> 18) & 0x3F];
    output[j++] = base64_table[(triple >> 12) & 0x3F];
    output[j++] = base64_table[(triple >> 6) & 0x3F];
    output[j++] = '=';
  }
  output[j] = '\0'; // Null-terminate the output
}

void base64_decode(const char *input, int len, unsigned char *output) {
  // Sanity Check
  if (len % 4 != 0) {
    output[0] = '\0';
    return;
  }

  int i = 0, j = 0;
  for (i; i < len; i += 4) {
    // Get values, treating padding chars as having value 0
    int s1 = decoding_table[(unsigned char) input[i]];
    int s2 = decoding_table[(unsigned char) input[i + 1]];
    int s3 = (input[i + 2] == '=') ? 0 : decoding_table[(unsigned char) input[i + 2]];
    int s4 = (input[i + 3] == '=') ? 0 : decoding_table[(unsigned char) input[i + 3]];

    unsigned int triple = (s1 << 18) | (s2 << 12) | (s3 << 6) | s4;

    // Output the 1st byte
    output[j++] = (triple >> 16) & 0xFF;

    // Output 2nd bytr if 3rd input char wasn't padding
    if (input[i + 2] != '=') {
      output[j++] = (triple >> 8) & 0xFF;
    }

    // Output 3rd byte if 4th input char wasn't padding
    if (input[i + 3] != '=') {
      output[j++] = triple & 0xFF;
    }
  }
  output[j] = '\0'; // Null-terminate the output
}

int main() {
  // Build the lookup table once at start of program
  build_decoding_table();

  const char *test_strings[] = {"M", "Ma", "Man", "Many", "Pleasure.", "Leasure.", "easure."};

  for (int i = 0; i < sizeof(test_strings) / sizeof(test_strings[0]); i++) {
    const char *text = test_strings[i];
    size_t text_len = strlen(text);

    // Calculate required buffer sizes
    size_t encoded_len_needed = 4 * ((text_len + 2) / 3);
    char encoded[encoded_len_needed + 1];

    printf("--- Test Case %d ---\n", i + 1);
    printf("Original: \"%s\"\n", text);

    // 1. Encode
    base64_encode((const unsigned char*) text, text_len, encoded);
    printf("Encoded:  \"%s\"\n", encoded);

    // 2. Decode
    size_t decoded_len_needed = 3 * (strlen(encoded) / 4);
    unsigned char decoded[decoded_len_needed + 1];
    base64_decode(encoded, strlen(encoded), decoded);
    printf("Decoded:  \"%s\"\n\n", (char *) decoded);
  }
  return 0;
}
