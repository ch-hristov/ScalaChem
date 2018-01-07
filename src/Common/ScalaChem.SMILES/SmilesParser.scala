package Common.ScalaChem.SMILES

import Common.ScalaChem.Infrastructure.{ChemicalElement, IAtom, IMolecule}
import Common.ScalaChem.MolGraph.{Atom, Molecule}

import scala.collection.immutable.Stack

class SmilesParser() {

  // The dictionary of possible aliphatic, aromatic and cyclic structures
  // The (,),[,] are directly used in the parser below

  private var _aliph : List[Char] = List('C','B','N','O','P','S','F','I')
  private var _aromatic : List[Char] = List('c','b','n','o','p','s','f','i')
  private var _cycles : List[Char] = List('1','2','3','4','5','6','7','8','9')

  def parseSmiles(smiles : String): IMolecule = {
    println("Starting parsing..");

    var numStack = Stack()
    val atomStack = Stack()
    var mol = new Molecule()
    var cycleMap = Map[Char,IAtom]();

    for(c <- smiles) {
      var next = c
      println("Next token : " + next)
      var index: Int = 0

      if ((_aliph.contains(next) && (index = _aliph.indexOf(next)) != -1) ||
         (_aromatic.contains(next) && (index = _aromatic(next)) != -1)) {

        var aliphaticAtom = _aliph(index);
        var element = ChemicalElement.withName(aliphaticAtom.toString)
        var atom = new Atom(element, 0)

        mol.appendElem(atom);
        var top = atom.asInstanceOf[IAtom];

        if(atomStack.length > 0)
          top = atomStack.top.asInstanceOf[IAtom]

        if(atomStack.length > 0)
          atomStack.pop

        if(top != null)
          mol.connect(top , atom , Common.ScalaChem.Infrastructure.BondType.Single)

        atomStack.push(atom)
      } else {

          if (_cycles.contains(next) && (index = _cycles.indexOf(next)) != -1) {

            var item = cycleMap.contains(next);

            if(item){
              if(atomStack.length > 0){
                var top = atomStack.top
                atomStack.pop
                mol.connect(cycleMap(next),top, Common.ScalaChem.Infrastructure.BondType.Single)
              }
              else{
                throw new Exception("Trying to create a cycle with no startig atom!")
              }
            }
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
