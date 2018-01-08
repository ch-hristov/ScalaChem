package Common.ScalaChem.SMILES

import Common.ScalaChem.Infrastructure.BondType.BondType
import Common.ScalaChem.Infrastructure.{IAtom, IMolecule}
import Common.ScalaChem.MolGraph.Molecule

class MoleculeParser extends SmilesParser {

  var mol : IMolecule = null
  def parseBond(atom1:IAtom, atom2 : IAtom, bondType: BondType): Boolean ={
    mol.connect(atom1,atom2,bondType)
    return true;
  }

  def parse(smiles : String): IMolecule={
    mol = new Molecule()
    parseSmiles(smiles,parseBond,x => mol += (x))
    return mol
  }

}
