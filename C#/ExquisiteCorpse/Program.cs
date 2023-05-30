using System;

namespace ExquisiteCorpse
{
    class Program
    {
        static void Main(string[] args)
        {
            BuildCreature(head: "bug");
            Console.WriteLine();
            //SwitchCase(1, 1, 1);
            RandomMode();
        }

        static void BuildCreature(string head = "random", string body = "random", string feet = "random")
        {
            Random random = new Random();

            int headNum;
            if (head == "random")
            {
                headNum = random.Next(1, 4);
            }
            else
            {
                headNum = TranslateToNumber(head);
            }

            int bodyNum;
            if (body == "random")
            {
                bodyNum = random.Next(1, 4);
            }
            else
            {
                bodyNum = TranslateToNumber(body);
            }

            int feetNum;
            if (feet == "random")
            {
                feetNum = random.Next(1, 4);
            }
            else
            {
                feetNum = TranslateToNumber(feet);
            }

            SwitchCase(headNum, bodyNum, feetNum);
        }

        static void RandomMode()
        {
            Random randomNumber = new Random();

            int head = randomNumber.Next(1, 4);
            int body = randomNumber.Next(1, 4);
            int feet = randomNumber.Next(0, 4);

            SwitchCase(head, body, feet);
        }

        static void SwitchCase(int head, int body, int feet)
        {
            switch (head)
            {
                case 1:
                    BugHead();
                    break;
                case 2:
                    GhostHead();
                    break;
                case 3:
                    MonsterHead();
                    break;
                default:
                    BugHead();
                    break;
            }

            switch (body)
            {
                case 1:
                    BugBody();
                    break;
                case 2:
                    GhostBody();
                    break;
                case 3:
                    MonsterBody();
                    break;
                default:
                    BugBody();
                    break;
            }


            switch (feet)
            {
                case 1:
                    BugFeet();
                    break;
                case 2:
                    GhostFeet();
                    break;
                case 3:
                    MonsterFeet();
                    break;
                default:
                    BugFeet();
                    break;
            }

        }

        static int TranslateToNumber(string creature)
        {
            switch (creature)
            {
                case "bug":
                    return 1;
                case "ghost":
                    return 2;
                case "monster":
                    return 3;
                default:
                    return 1;
            }
        }

        static void GhostHead()
        {
            Console.WriteLine("     ..-..");
            Console.WriteLine("    ( o o )");
            Console.WriteLine("    |  O  |");
        }

        static void GhostBody()
        {
            Console.WriteLine("    |     |");
            Console.WriteLine("    |     |");
            Console.WriteLine("    |     |");
        }

        static void GhostFeet()
        {
            Console.WriteLine("    |     |");
            Console.WriteLine("    |     |");
            Console.WriteLine("    '~~~~~'");
        }

        static void BugHead()
        {
            Console.WriteLine("     /   \\");
            Console.WriteLine("     \\. ./");
            Console.WriteLine("    (o + o)");
        }

        static void BugBody()
        {
            Console.WriteLine("  --|  |  |--");
            Console.WriteLine("  --|  |  |--");
            Console.WriteLine("  --|  |  |--");
        }

        static void BugFeet()
        {
            Console.WriteLine("     v   v");
            Console.WriteLine("     *****");
        }

        static void MonsterHead()
        {
            Console.WriteLine("     _____");
            Console.WriteLine(" .-,;='';_),-.");
            Console.WriteLine("  \\_\\(),()/_/");
            Console.WriteLine("　  (,___,)");
        }

        static void MonsterBody()
        {
            Console.WriteLine("   ,-/`~`\\-,___");
            Console.WriteLine("  / /).:.('--._)");
            Console.WriteLine(" {_[ (_,_)");
        }

        static void MonsterFeet()
        {
            Console.WriteLine("    |  Y  |");
            Console.WriteLine("   /   |   \\");
            Console.WriteLine("   \"\"\"\" \"\"\"\"");
        }
    }
}
