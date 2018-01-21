package Common.ScalaChem.MolGraph
import Common.ScalaChem.Infrastructure.BondType.BondType
import Common.ScalaChem.Infrastructure.{IAtom, IBond, IMolecule}

import scala.collection.mutable

///An object that describes a molecule and methods related to it.
// It provides methods to compute various properties on the molecule
// and also offers a way to access the atoms in the molecule
class Molecule extends mutable.MutableList[IAtom] with IMolecule {

  // returns the list of all bonds
  def bonds() : mutable.ListBuffer[IBond] = {
    return _bonds
  }

  // Clones the molecule
  // Returns the cloned molecule and a correspondence map
  // which maps the atom from one to the other molecule
  // in order to measure equality
  def clone_with_map() : (mutable.Map[IAtom,IAtom],IMolecule) = {
    var newMol = new Molecule()

    var mps = mutable.Map[IAtom,IAtom]();

    for(i <- this){
      var at = new Atom(i.Element,0)
      newMol.appendElem(at)
      mps(i) = at;
    }

    if(this.length > 0){
      var visited = mutable.Map[IAtom,Boolean]()
      return (mps,this.dfs_connect_atoms(newMol,this(0),mps,visited));
    }
    else{
      throw new Exception("Trying to clone an empty molecule")
    }
  }

  // maps the bonds from the cloned to the clone
  private def dfs_connect_atoms(result : Molecule,
                  curr : IAtom,
                  atomMap : mutable.Map[IAtom,IAtom],
                  visited : mutable.Map[IAtom,Boolean]): Molecule ={

    for(i <- curr.connections()){
        if(!visited(i)) {
          result.connect(atomMap(curr), atomMap(i.To), i.Type)
          dfs_connect_atoms(result, i.To ,atomMap,visited)
        }
    }

    return result;
  }

  private var _atomId = 0
  private var _num = mutable.Map[IAtom,Integer]()
  private var _graph = mutable.Map[IAtom,mutable.MutableList[IBond]]()
  private var _bonds = mutable.ListBuffer[IBond]()

  // Appends a new atom to the list of atoms
  override def appendElem(elem: IAtom): Unit = {
    _graph(elem) = new mutable.MutableList[IBond]()
    _num(elem)=_atomId
    this._atomId = this._atomId + 1
    elem.setMolecule(this)
    super.appendElem(elem)
  }

  // Connects two atoms a and b with a bond of type t
  override def connect(a: IAtom, b: IAtom, t : BondType): Boolean = {
    if(!this.contains(a) || !this.contains(b))
      return false
    val bond = new Bond(a,b,t)
    _graph(a) += bond
    _graph(b) += bond
    _bonds += bond.asInstanceOf[IBond]
    return true
  }

  // Returns a smiles of the molecule
  // This method is not implemented yet as
  // we only implemented the SMILES to graph,
  // therefore this method is not complete and should not be used yet.
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
  //return the neighbours of atom : atom
  override def neighboursOf(atom: IAtom): List[IBond] ={
    return this._graph(atom).toList;
  }
}