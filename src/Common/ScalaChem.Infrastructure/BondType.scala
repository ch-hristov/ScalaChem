package Common.ScalaChem.Infrastructure

object BondType extends Enumeration(1){
    type BondType = Value
    val Single    = Value(1)
    val Double    = Value(2)
    val Triple    = Value(3)
    val Quadruple = Value(4)
    val Dative    = Value(5)
    val Complex   = Value(6)
    val Ionic     = Value(7)
    val Unknown   = Value(255)
}