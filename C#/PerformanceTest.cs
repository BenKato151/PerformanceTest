using System;
using System.Diagnostics;
using System.Security.Cryptography;
using System.Text;

namespace PerformanceTest
{
    class PerformanceTest
    {
        static void Main(string[] args)
        {
            string data = "aaaaaaaaaa";
            Stopwatch time = new Stopwatch();
            time.Start();

            for (int i = 0; i < 1000000; i++)
            {
                try
                {
                    string hashvalue = ComputeSha256Hash(data);
                }
                catch (Exception)
                {
                    throw;
                }
            }
            time.Stop();
            Debug.WriteLine("Duration: " + (long)time.Elapsed.Milliseconds * 1000);
        }

        private static string ComputeSha256Hash(string rawData)
        {
            using (SHA256 sha256Hash = SHA256.Create())
            {
                byte[] bytes = sha256Hash.ComputeHash(Encoding.UTF8.GetBytes(rawData));

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < bytes.Length; i++)
                {
                    builder.Append(bytes[i].ToString("x2"));
                }
                return builder.ToString();
            }
        }
    }
}
