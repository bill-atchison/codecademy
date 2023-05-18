using System;

namespace MoneyMaker
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            const int bronzeCoin = 1;
            const int silverCoin = 5;
            const int goldCoin = 10;

            Console.WriteLine("Welcome to Money Maker!");

            Console.Write("Enter amount to convert: ");
            double amount = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine($"{amount} cents is equal to...");

            int goldCoins = (int) Math.Floor(amount / goldCoin);

            amount %= goldCoin;

            int silverCoins = (int) Math.Floor(amount / silverCoin);

            int bronzeCoins = (int) amount % silverCoin;

            Console.WriteLine($"Gold coins: {goldCoins}");
            Console.WriteLine($"Silver coins: {silverCoins}");
            Console.WriteLine($"Bronze coins: {bronzeCoins}");

        }
    }
}
