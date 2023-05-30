using System;

namespace PasswordChecker
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int minLength = 8;
            string uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            string lowercase = "abcdefghijklmnopqrstuvwxyz";
            string digits = "1234567890";
            string specialChars = "!$#%^?";

            Console.Write("Enter a password: ");
            string password = Console.ReadLine();  

            int score = 0;

            if (password.Length >= minLength)
            {
                score++;
            }
                
            if (Tools.Contains(password, uppercase))
            {
                score++;
            }

            if (Tools.Contains(password, lowercase))
            {
                score++;
            }
         
            if (Tools.Contains(password, digits))
            {
                score++;
            }

            if (Tools.Contains(password, specialChars))
            {
                score++;
            }

            if ((password.Equals("password", StringComparison.OrdinalIgnoreCase)) ||
                (password == "1234")) {
                score = 0;
            }

            Console.WriteLine(score);

            switch (score)
            {
                case 5:
                case 4: 
                    Console.WriteLine("password is extremely strong");
                    break;
                case 3: 
                    Console.WriteLine("password is strong");
                    break;
                case 2:
                    Console.WriteLine("password is medium");
                    break;
                case 1:
                    Console.WriteLine("password is weak");
                    break;
                default:
                    Console.WriteLine("password doesn't meet any of the standards");
                    break;
            }
        }
    }
}