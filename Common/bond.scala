package smiles

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
/**
 * Class to represent a bond between two atoms
 * Initialize with begin and end atom IDs, bond order and bond style.
 * @param: aid1: Begin atom id
 * @param: aid2: End atom id
 * @param: order: Bond order
 * 
 */
class Bond(val aid1 : Int, val aid2 : Int, val order : Int = BondType(1).id) {
    /**  
	 * Override the equals method for Bond
	 * With this, expressions like b1 equals b2 or b1==b2 will work if all values are the same. 
	 */
    override def equals(other: Any) = other match {
        case that: Bond => this.aid1 == that.aid1 && this.aid2 == that.aid2 && this.order == that.order
        case _ => false
    }
}