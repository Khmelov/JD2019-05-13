package by.it.yakovets.jd02_02;



public interface IUseBacket {
    Basket takeBasket();

    void putGoodsToBasket(Basket basket, Good choosedGood);
}