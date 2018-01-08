package Common.ScalaChem.FunctionalMolGraph

import Common.ScalaChem.FunctionalMolGraph.Bond
import Common.ScalaChem.FunctionalMolGraph.Atom
import Common.ScalaChem.Infrastructure.BondType.BondType
import Common.ScalaChem.Infrastructure.{BondType, IAtom, IBond, IMolecule}

import scala.collection.mutable

class Molecule extends mutable.MutableList[IAtom] with IMolecule {

  private var _atomId = 0
  private var _num = mutable.Map[IAtom,Integer]()
  private var _graph = mutable.Map[IAtom,mutable.MutableList[IBond]]()

  def bonds() : mutable.ListBuffer[IBond] = {
    throw new Exception("Not implemented")
  }


  override def appendElem(elem: IAtom): Unit = {
    _graph(elem) = new mutable.MutableList[IBond]()
    _num(elem)=_atomId
    this._atomId = this._atomId + 1
    elem.setMolecule(this)
    super.appendElem(elem)
  }

  override def connect(a: IAtom, b: IAtom, t : BondType): Boolean = {

    if(!this.contains(a) || !this.contains(b))
      return false

    val bond = new Bond(a,b,t)

    _graph(a) += bond
    _graph(b) += bond

    return true
  }

  override def toString: String = {
    return this.getSmiles()
  }

  private def getSmiles(): String ={
    var str = "";
    this.foreach(v => {
      str += v.toString()
    })
    return str;
  }

  override def neighboursOf(atom: IAtom): List[IBond] ={
    return this._graph(atom).toList;
  }
}
