package ScalaChem.Infrastructure
import ScalaChem.Infrastructure
import ScalaChem.Infrastructure.ChemicalElement.ChemicalElement
import ScalaChem.MolGraph.Molecule

trait IAtom {
    def setMolecule(molecule: IMolecule)
    def connections() : List[IBond]

    var molecule : IMolecule
    var Element : ChemicalElement

}