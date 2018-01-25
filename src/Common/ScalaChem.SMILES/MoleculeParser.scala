package Common.ScalaChem.SMILES

import Common.ScalaChem.Infrastructure.BondType.BondType
import Common.ScalaChem.Infrastructure.{IAtom, IMolecule}
import Common.ScalaChem.MolGraph.Molecule

class MoleculeParser extends SmilesParser {

  var mol : Molecule = null

  // A callback handler to create a bond between atom1 and atom2 with
  // bond type 'bondType'. This is needed since the parser produces
  // events when a bond or an atom to be added is encountered.
   private def parseBond(atom1:IAtom, atom2 : IAtom, bondType: BondType): Boolean ={
    mol.connect(atom1,atom2,bondType)
    return true;
  }

  def parseAtom(atom : IAtom): Unit ={
    mol.appendElem(atom)
  }

  // Produces a molecule graph out of a SMILES formatted string
  def parse(smiles : String): IMolecule={
    mol = new Molecule()
    parseSmiles(smiles,parseBond,parseAtom);
    return mol
  }

}
