import org.scalatest.funsuite.AnyFunSuite

  class ShoppingBasketTest extends AnyFunSuite {

        val basket: List[String] = List("Apples", "Apples", "Soup","Soup", "Bread", "Milk", "Soup")

        test("shoppingbasket.subtotal") {
          assert(ShoppingBasket.subtotal(basket).round === 6.05.round)
        }

        test("shoppingbasket.applediscount") {
          assert(ShoppingBasket.applediscount(basket).round === 0.2.round)
        }

        test("shoppingbasket.soupbreaddiscount") {
          assert(ShoppingBasket.soupbreaddiscount(basket).round === 0.4.round)
        }

        test("shoppingbasket.results") {
          val finalprice: Double = ShoppingBasket.results(6.05, 0.2, 0.4)
          assert(finalprice.round === 5.45.round)
        }
    }