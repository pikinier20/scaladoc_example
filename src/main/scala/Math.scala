package org.virtuslab.scaladoc_example

object MyMath:

  opaque type Logarithm = Double

  /** 
   * 
   * ```scala sc:nocompile
   * val l = Logarithm(1.0)
   * val l2 = Logarithm(2.0)
   * val l3 = l * l2
   * val l4 = l + l2
   * ```
   * 
   * But the following operations would lead to type errors:
   * ```scala  sc:nocompile
   * val d: Double = l
   * val l2: Logarithm = 1.0
   * l * 2
   * l / l2
   * ```
   * 
   * In the future there'll be other operations like:
   * ```scala sc:nocompile
   * -Logarithm(1.0)
   * Logarithm(1.0)
   * Logarithm(1.0)^10
   * ```
   */
  object Logarithm:

    // These are the two ways to lift to the Logarithm type

    def apply(d: Double): Logarithm = math.log(d)

    def safe(d: Double): Option[Logarithm] =
      if d > 0.0 then Some(math.log(d)) else None

  end Logarithm

  // Extension methods define opaque types' public APIs
  // TODO: Implement other operations
  extension (x: Logarithm)
    def toDouble: Double = math.exp(x)
    def + (y: Logarithm): Logarithm = Logarithm(math.exp(x) + math.exp(y))
    def * (y: Logarithm): Logarithm = x + y

end MyMath