package ScalaChem.MolGraph
import ScalaChem.Infrastructure

class Atom extends IAtom (val aid : Int, val anum : ChemicalElement, var charge : Int = 0){
    /**  
	 * Override the equals method for Atoms
	 * With this, expressions like a1 equals a2 or a1==a2 will work if all values are the same. 
	 */
    override def equals(other: Any) = other match {
        case that: Atom => this.anum == that.anum
        case _ => false
    }
    
    override def toString() : String = {
        val elem = this.element()
        s"Element: \n\tSymbol: $elem\n\tAtomic Number: $anum\n\tCharge: $charge"
    }
}