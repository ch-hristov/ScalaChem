package Common.ScalaChem.SMILES

import Common.ScalaChem.Infrastructure.{ChemicalElement, IAtom, IMolecule}
import Common.ScalaChem.MolGraph.{Atom, Molecule}

import scala.collection.immutable.Stack

class SmilesParser() {
  private var _aliph : List[Char] = List('C','B','N','O','P','S','F','I')
  private var _aromatic : List[Char] = List('c','b','n','o','p','s','f','i')
  private var _cycles : List[Char] = List('1','2','3','4','5','6','7','8','9')

  def parseSmiles(smiles : String): IMolecule = {
    println("Starting parsing..");

    val atomStack = Stack()
    var mol = new Molecule()

    for(c <- smiles) {

      var next = c
      println("Next token is : " + next);

      var index: Int = 0

      if ((index = _aliph.indexOf(next)) != -1 || (index = _aromatic(next)) != -1) {
        var aliphaticAtom = _aliph(index);

        var element = ChemicalElement.withName(aliphaticAtom.toString)
        var atom = new Atom(element, 0)

        var top = atomStack.top.asInstanceOf[IAtom]
        if(atomStack.length > 0)
          atomStack.pop

        mol.appendElem(atom)
        mol.connect(top , atom , Common.ScalaChem.Infrastructure.BondType.Single)
        atomStack.push(atom)

      } else {
          if ((index = _cycles.indexOf(next)) != -1) {
            var cycleIndex = _cycles(next);
          }
          else if (next == '(') {
            if (atomStack.isEmpty) throw new Exception("Cannot start a branch here");
            atomStack.push(atomStack.top)
          }

          else if (next == ')') {
            if (atomStack.size < 2) throw new Exception("Closing of an unopened branch, SMILES may be truncated:")
            atomStack.pop
        }
      }
    }
    return mol;
  }
}
