package Common.ScalaChem.SMILES

import java.nio.CharBuffer
import java.util

import ScalaChem.Infrastructure.{ChemicalElement, IMolecule}

import scala.collection.immutable.Stack
import Common.ScalaChem.MolGraph
import Common.ScalaChem.MolGraph.{Atom, Molecule}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class SmilesParser() {
  private var _aliph : List[Char] = List('C','B','N','O','P','S','F','I')
  private var _aromatic : List[Char] = List('c','b','n','o','p','s','f','i')
  private var _cycles : List[Char] = List('1','2','3','4','5','6','7','8','9')

  def parseSmiles(smiles : String): IMolecule = {

    var buffer = CharBuffer.allocate(100);
    smiles.foreach(x => buffer.put(x))

    val stack = Stack()
    var mol = new Molecule()

    while(buffer.hasRemaining()) {
      var next = buffer.get();
      var index: Int = 0

      if ((index = _aliph.indexOf(next)) != -1) {
        var aliphaticAtom = _aliph(index);
        var element = ChemicalElement.withName(aliphaticAtom.toString)
        mol.appendElem(new Atom(element, 0));
      } else {
        if ((index = _aromatic.indexOf(next)) != -1) {
          //TODO: Add additional logic here for aromatic atoms
          var aromaticAtom = _aromatic(index);
          var element = ChemicalElement.withName(aromaticAtom.toString)
          mol.appendElem(new Atom(element, 0));
        }
        else {
          if ((index = _cycles.indexOf(next)) != -1) {
            var cycleIndex = _cycles(next);

          }
          else if (next == '(') {
            if (stack.isEmpty) throw new Exception("Cannot start a branch here");
            stack.push(stack.top)
          }
          else if (next == ')') {
            if (stack.size < 2) throw new Exception("Closing of an unopened branch, SMILES may be truncated:")
            stack.pop;
          }
        }
      }
    }

    return mol;
  }
}
