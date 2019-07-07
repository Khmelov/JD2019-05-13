package by.it.yakovets.jd02_03;


public interface IUseBacket {
    Basket takeBasket();

    void putGoodsToBasket(Basket basket, Good choosedGood);
}