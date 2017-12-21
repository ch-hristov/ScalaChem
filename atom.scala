package smiles/**
 * Define an Element enumeration and assign the atomic numbers to each Element
 * For use in the Atom class
 */
object Element extends Enumeration(1){
    type Element = Value
    val H  =  Value(1)
    val He =  Value(2)
    val Li =  Value(3)
    val Be =  Value(4)
    val B  =  Value(5)
    val C  =  Value(6)
    val N  =  Value(7)
    val O  =  Value(8)
    val F  =  Value(9)
    val Ne =  Value(10)
    val Na =  Value(11)
    val Mg =  Value(12)
    val Al =  Value(13)
    val Si =  Value(14)
    val P  =  Value(15)
    val S  =  Value(16)
    val Cl =  Value(17)
    val Ar =  Value(18)
    val K  =  Value(19)
    val Ca =  Value(20)
    val Sc =  Value(21)
    val Ti =  Value(22)
    val V  =  Value(23)
    val Cr =  Value(24)
    val Mn =  Value(25)
    val Fe =  Value(26)
    val Co =  Value(27)
    val Ni =  Value(28)
    val Cu =  Value(29)
    val Zn =  Value(30)
    val Ga =  Value(31)
    val Ge =  Value(32)
    val As =  Value(33)
    val Se =  Value(34)
    val Br =  Value(35)
    val Kr =  Value(36)
    val Rb =  Value(37)
    val Sr =  Value(38)
    val Y  =  Value(39)
    val Zr =  Value(40)
    val Nb =  Value(41)
    val Mo =  Value(42)
    val Tc =  Value(43)
    val Ru =  Value(44)
    val Rh =  Value(45)
    val Pd =  Value(46)
    val Ag =  Value(47)
    val Cd =  Value(48)
    val In =  Value(49)
    val Sn =  Value(50)
    val Sb =  Value(51)
    val Te =  Value(52)
    val I  =  Value(53)
    val Xe =  Value(54)
    val Cs =  Value(55)
    val Ba =  Value(56)
    val La =  Value(57)
    val Ce =  Value(58)
    val Pr =  Value(59)
    val Nd =  Value(60)
    val Pm =  Value(61)
    val Sm =  Value(62)
    val Eu =  Value(63)
    val Gd =  Value(64)
    val Tb =  Value(65)
    val Dy =  Value(66)
    val Ho =  Value(67)
    val Er =  Value(68)
    val Tm =  Value(69)
    val Yb =  Value(70)
    val Lu =  Value(71)
    val Hf =  Value(72)
    val Ta =  Value(73)
    val W  =  Value(74)
    val Re =  Value(75)
    val Os =  Value(76)
    val Ir =  Value(77)
    val Pt =  Value(78)
    val Au =  Value(79)
    val Hg =  Value(80)
    val Tl =  Value(81)
    val Pb =  Value(82)
    val Bi =  Value(83)
    val Po =  Value(84)
    val At =  Value(85)
    val Rn =  Value(86)
    val Fr =  Value(87)
    val Ra =  Value(88)
    val Ac =  Value(89)
    val Th =  Value(90)
    val Pa =  Value(91)
    val U  =  Value(92)
    val Np =  Value(93)
    val Pu =  Value(94)
    val Am =  Value(95)
    val Cm =  Value(96)
    val Bk =  Value(97)
    val Cf =  Value(98)
    val Es =  Value(99)
    val Fm =  Value(100)
    val Md =  Value(101)
    val No =  Value(102)
    val Lr =  Value(103)
    val Rf =  Value(104)
    val Db =  Value(105)
    val Sg =  Value(106)
    val Bh =  Value(107)
    val Hs =  Value(108)
    val Mt =  Value(109)
    val Ds =  Value(110)
    val Rg =  Value(111)
    val Cp =  Value(112)
    val ut =  Value(113)
    val uq =  Value(114)
    val up =  Value(115)
    val uh =  Value(116)
    val us =  Value(117)
    val uo =  Value(118)
}
/**
 * Class to represent an atom in a :class:
 * Initialize with an atom ID, atomic number, coordinates and optional change.
 * @param aid: Atom ID
 * @param anum: Atomic number
 * @param x: X coordinate
 * @param y: Y coordinate
 * @param z: Z coordinate (optional)
 * @param charge: Formal charge of an atom (optional)
 */
class Atom (val aid : Int, val anum : Int, var x : Int, var y : Int,  var z : Int = 0, var charge : Int = 0){
    /**
     * Return the element symbol for this atom as a string
     */
    def element() : String = {
        import Element._
        Element(aid).toString()
    }
    
    /**
     * Set all the coordinates of the atom at once
     */
    def set_coordinates(new_x : Int, new_y : Int, new_z : Int = 0) {
        x = new_x
        y = new_y
        z = new_z
    }
    
    
    /**  
	 * Override the equals method for Atoms
	 * With this, expressions like a1 equals a2 or a1==a2 will work if all values are the same. 
	 */
    override def equals(other: Any) = other match {
        case that: Atom => this.aid == that.aid && this.anum == that.anum && this.x == that.x && this.y == that.y && this.z == that.z && this.charge == that.charge
        case _ => false
    }
    
    override def toString() : String = {
        val elem = this.element()
        s"Element: \n\tSymbol: $elem\n\tAtomic Number: $anum\n\tCharge: $charge"
    }
}

