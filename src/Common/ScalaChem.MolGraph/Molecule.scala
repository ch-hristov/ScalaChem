package ScalaChem.MolGraph

import ScalaChem.Infrastructure.{IAtom, IBond, IMolecule}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


class Molecule extends mutable.MutableList[IAtom] with IMolecule {
  private var _atomId = 0
  private var _num = mutable.Map[IAtom,Integer]()
  private var _graph = mutable.Map[IAtom,mutable.MutableList[IAtom]]()

  override def appendElem(elem: IAtom): Unit = {
    _graph(elem) = new mutable.MutableList[IAtom]()
    _num(elem)=_atomId
    this._atomId = this._atomId + 1
    elem.setMolecule(this)
    super.appendElem(elem)
  }

  override def connect(a: IAtom, b: IAtom): Boolean = {
    if(!this.contains(a) || !this.contains(b))
      return false
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

  override def neighboursOf(atom: Atom): List[IBond] ={
    return null
  }
}