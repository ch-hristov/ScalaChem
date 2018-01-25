package Common.ScalaChem.MolGraph
import Common.ScalaChem.Infrastructure.BondType.BondType
import Common.ScalaChem.Infrastructure.{IAtom, IBond, IMolecule}

import scala.collection.mutable

///An object that describes a molecule and methods related to it.
// It provides methods to compute various properties on the molecule
// and also offers a way to access the atoms in the molecule
class Molecule extends IMolecule {
  var Graph = mutable.Map[IAtom,mutable.ListBuffer[IBond]]()
  // returns the list of all bonds
  def bonds() : mutable.ListBuffer[IBond] = {
    return _bonds
  }

  def disconnect(atom : IAtom): Unit ={

    var iter = Graph(atom)
    for(i <- 0 to iter.length - 1){
      var item = iter(i)
      Graph(item.To) -= item
      Graph(atom) -= item
    }
    Graph.remove(atom)

  }

  // Clones the molecule
  // Returns the cloned molecule and a correspondence map
  // which maps the atom from one to the other molecule
  // in order to measure equality
  def clone_with_map() : (mutable.Map[IAtom,IAtom],IMolecule) = {
    var newMol = new Molecule()

    var mps = mutable.Map[IAtom,IAtom]();

    for(i <- Graph.keys){
      var at = new Atom(i.Element,0)
      newMol.appendElem(at)
      mps(i) = at;
    }

    if(Graph.keys.size > 0){
      var visited = mutable.Map[IAtom,Boolean]()
      return (mps,this.bfs_connect_atoms(newMol,Graph.keys.last,mps,visited));
    }
    else{
      throw new Exception("Trying to clone an empty molecule")
    }
  }

  def bfs_connect_atoms(mol : Molecule, atom : IAtom,atomMap : mutable.Map[IAtom,IAtom], visited : mutable.Map[IAtom,Boolean] ): Molecule ={
    var q = new mutable.Queue[IAtom]()
    q.enqueue(atom)

    while(q.length > 0){
      var top = q.dequeue()
      visited(top)=true
      for(x <- top.connections()){
        if(!visited.contains(x.To)){
          mol.connect(atomMap(top),atomMap(x.To),x.Type)
          q.enqueue(x.To)
        }
      }
    }

    return  mol;
  }

  private var _atomId = 0
  private var _num = mutable.Map[IAtom,Integer]()
  private var _bonds = mutable.ListBuffer[IBond]()

  // Appends a new atom to the list of atoms
  def appendElem(elem: IAtom): Unit = {
    Graph(elem) = new mutable.ListBuffer[IBond]()
    _num(elem)=_atomId
    this._atomId = this._atomId + 1
    elem.setMolecule(this)
  }

  // Connects two atoms a and b with a bond of type t
  override def connect(a: IAtom, b: IAtom, t : BondType): Boolean = {
    if(!Graph.contains(a) || !Graph.contains(b))
      return false
    val bond = new Bond(a,b,t)
    Graph(a) += bond
    Graph(b) += bond
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
    Graph.keys.foreach(v => {
      str += v.toString()
    })
    return str;
  }
  //return the neighbours of atom : atom
  override def neighboursOf(atom: IAtom): List[IBond] ={
    var neighbours = Graph(atom).toList;
    return neighbours;
  }
}