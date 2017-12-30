package ScalaChem.Infrastructure
import ScalaChem.Infrastructure
import ScalaChem.MolGraph.Atom

trait IMolecule {
  def neighboursOf(atom: Atom): scala.List[_root_.ScalaChem.Infrastructure.IBond]
  def connect(a : IAtom, b : IAtom, t : BondType) : Boolean
}