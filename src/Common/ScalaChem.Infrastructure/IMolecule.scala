package ScalaChem.Infrastructure
import ScalaChem.Infrastructure

trait IMolecule {
    var Atoms : List[IAtom]
    def Connect(a : IAtom, b : IAtom)
}