#include <iostream>
#include "picosha2.h"
#include <chrono>

void CalcAndOutput(const std::string& src){
	//std::cout << "hash: " << picosha2::hash256_hex_string(src) << std::endl;
	std::string out = picosha2::hash256_hex_string(src);
}

int main(int argc, char* argv[])
{

	std::chrono::steady_clock::time_point begin = std::chrono::steady_clock::now();
	char* s = "aaaaaaaaaa";
	for (int j = 0; j < 1000000; ++j) {
		CalcAndOutput(s);
	}

	std::chrono::steady_clock::time_point end = std::chrono::steady_clock::now();
	std::cout << "Time difference = " << std::chrono::duration_cast<std::chrono::microseconds>(end - begin).count() << "[µs]" << std::endl;
  return 0;
}
