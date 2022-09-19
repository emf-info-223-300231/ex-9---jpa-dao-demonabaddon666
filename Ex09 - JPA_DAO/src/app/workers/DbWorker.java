package app.workers;

import app.beans.Departement;
import app.beans.Localite;
import app.beans.Personne;
import app.exceptions.MyDBException;
import app.workers.dao.FileDao;
import app.workers.dao.FileDaoItf;
import app.workers.dao.JpaDao;
import app.workers.dao.JpaDaoItf;
import app.workers.extracters.DepartementExtracter;
import app.workers.extracters.LocaliteExtracter;

import java.io.File;
import java.util.List;

/**
 * Couche "métier" gérant les accès de et vers la base de données.
 *
 * @author ramalhom
 */
public class DbWorker implements DbWorkerItf {

    private static final String JPA_PU = "PU_MYSQL";
    private final JpaDaoItf<Personne, Integer> persWrk;
    private final JpaDaoItf<Localite, Integer> locWrk;
    private final JpaDaoItf<Departement, Integer> depWrk;
    private final FileDaoItf<Localite> ficLocWrk;
    private final FileDaoItf<Departement> ficDepWrk;

    /**
     * Constructeur.
     *
     * @throws MyDBException
     */
    public DbWorker() throws MyDBException {
        persWrk = new JpaDao<>(JPA_PU, Personne.class);
        locWrk = new JpaDao<>(JPA_PU, Localite.class);
        depWrk = new JpaDao<>(JPA_PU, Departement.class);
        ficLocWrk = new FileDao<>(new LocaliteExtracter("\t"));
        ficDepWrk = new FileDao<>(new DepartementExtracter(";"));
    }

    @Override
    public List<Personne> lirePersonnes() throws MyDBException {
        return persWrk.lireListe();
    }

    @Override
    public long compterPersonnes() throws MyDBException {
        return persWrk.compter();
    }

    @Override
    public Personne rechercherPersonneAvecNom(String nomARechercher) throws MyDBException {
        return persWrk.rechercher("nom",nomARechercher);
    }

    @Override
    public List<Localite> lireLocalites() throws MyDBException {
        return locWrk.lireListe();
    }

    @Override
    public long compterLocalites() throws MyDBException {
        return locWrk.compter();
    }

    @Override
    public int lireEtSauverLocalites(File fichier, String nomCharset) throws Exception {
        for (Localite loc: ficLocWrk.lireFichierTexte(fichier,nomCharset)) {
            locWrk.modifier(loc);
        }
        return ficLocWrk.lireFichierTexte(fichier,nomCharset).size();
    }

    @Override
    public List<Departement> lireDepartements() throws MyDBException {
        return depWrk.lireListe();
    }

    @Override
    public long compterDepartements() throws MyDBException {
        return depWrk.compter();
    }

    @Override
    public int lireEtSauverDepartements(File fichier, String nomCharset) throws Exception {
        for (Departement loc: ficDepWrk.lireFichierTexte(fichier,nomCharset)) {
            depWrk.modifier(loc);
        }
        return ficDepWrk.lireFichierTexte(fichier,nomCharset).size();
    }

    @Override
    public void effacerPersonne(Personne p) throws MyDBException {
        persWrk.effacer(p.getId());
    }

    @Override
    public void modifierPersonne(Personne p) throws MyDBException {
        persWrk.modifier(p);
    }

    @Override
    public Personne lirePersonne(Personne p) throws MyDBException {
        return persWrk.lire(p.getId());
    }

    @Override
    public void ajouterPersonne(Personne p) throws MyDBException {
        persWrk.creer(p);
    }

    /*
   * AUTRES
     */
    @Override
    public void fermerBD() {
        persWrk.deconnecter();
        locWrk.deconnecter();
        depWrk.deconnecter();
    }

    @Override
    public boolean estConnecte() {
        return true;
    }


 

}
