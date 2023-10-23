object ShoppingBasket {

  val itemPrices: Map[String, Double] = Map(
    "Soup" -> 0.65,
    "Bread" -> 0.80,
    "Milk" -> 1.30,
    "Apples" -> 1.00
  )
  val specialOffers: Map[String, Double] = Map(
    "Apples" -> 0.1,
    "Soup" -> 2,
    "Bread" -> 0.5
  )


  def main(args: Array[String]): Unit = {

    val basket = args.toList
    println("basket", basket)
    val sub_total = subtotal(basket)
    val apple_discount = applediscount(basket)
    val soup_bread_disc = soupbreaddiscount(basket)
    results(sub_total,apple_discount,soup_bread_disc)
    basket
  }

  // calculate original total of items in shopping basket
  def subtotal(basket: List[String]): Double = {
    val subtotal = (for {
      item <- basket
      price <- itemPrices.get(item)
    } yield price).sum
    subtotal
  }

  // apples discount calculation
  def applediscount(basket: List[String]): Double = {
    val appleCount = basket.count(_ == "Apples")
    val appleDiscount = appleCount * itemPrices("Apples") * specialOffers("Apples")
    appleDiscount
  }

  //bread discount calculation
  def soupbreaddiscount(basket: List[String]): Double = {
    val soupCount = basket.count(_ == "Soup")
    val breadCount = basket.count(_ == "Bread")
    val applicableDiscounts = Math.min(soupCount / specialOffers("Soup"), breadCount)
    val soupBreadDiscount = applicableDiscounts * itemPrices("Bread") * specialOffers("Bread")
    soupBreadDiscount
  }

  //output
  def results(subtotal: Double, appleDiscount: Double, soupBreadDiscount: Double): Double = {
    val final_price = subtotal - appleDiscount - soupBreadDiscount //total_discount
    println(s"Subtotal: £$subtotal")
    if (appleDiscount > 0) {
      if (appleDiscount < 1) {
        println(s"Apples 10% off: $appleDiscount p")
      }
      else {
        println(s"Apples 10% off: £$appleDiscount")
      }
    }
    if (soupBreadDiscount > 0) {
      if (soupBreadDiscount < 1) {
        println(s"Bread 50% off: $soupBreadDiscount p")
      }
      else {
        println(s"Buy 2 tins of soup and get a loaf of bread 50% off: £$soupBreadDiscount")
      }
    }
    println(s"Total price: £$final_price")
    final_price

  }
}

