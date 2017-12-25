package ScalaChem.Infrastructure
import ScalaChem.Infrastructure

class BondType extends Enumeration {
    type BondType = Value

    val Single = Value("Single")
    val Double = Value("Double")
    val Triple = Value("Triple")
}