package com.quizify;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.quizify.model.Categorie;
import com.quizify.model.Question;
import com.quizify.model.Reponse;
import com.quizify.repository.CategorieRepository;
import com.quizify.repository.QuestionRepository;
import com.quizify.repository.ReponseRepository;

@SpringBootTest
class QuizifyApplicationTests {

	@Autowired
	private CategorieRepository categorieRepo;

	@Autowired
	private QuestionRepository questionRepo;

	@Autowired
	private ReponseRepository reponseRepo;

	@BeforeEach
	void clean() {

		reponseRepo.deleteAll();
		questionRepo.deleteAll();
		categorieRepo.deleteAll();
	}

	@Test
	void addData() {

		// Catégories
		Categorie animaux = new Categorie("Animaux");
		Categorie musique = new Categorie("Musique");
		Categorie cinema = new Categorie("Cinema");
		Categorie sport = new Categorie("Sport");

		// Sauvegarde des categories
		categorieRepo.saveAll(Arrays.asList(animaux, musique, cinema, sport));

		// Animaux

		Question oiseauVitesseQ = new Question("Quel est l'oiseau le plus rapide en vol ?", animaux);
		Reponse oiseauA = new Reponse("Le faucon pèlerin", true, oiseauVitesseQ);
		Reponse oiseauB = new Reponse("L'aigle royal", false, oiseauVitesseQ);
		Reponse oiseauC = new Reponse("Le perroquet", false, oiseauVitesseQ);
		Reponse oiseauD = new Reponse("L'autruche", false, oiseauVitesseQ);

		Question grandMammifereMarinQ = new Question("Quel est le plus grand mammifère marin ?", animaux);
		Reponse grandMammifereA = new Reponse("La baleine bleue", true, grandMammifereMarinQ);
		Reponse grandMammifereB = new Reponse("Le requin blanc", false, grandMammifereMarinQ);
		Reponse grandMammifereC = new Reponse("L'éléphant de mer", false, grandMammifereMarinQ);
		Reponse grandMammifereD = new Reponse("L'orque", false, grandMammifereMarinQ);

		Question animalCouleurQ = new Question(
				"Quel animal est capable de changer de couleur pour se camoufler dans son environnement ?", animaux);
		Reponse animalCouleurA = new Reponse("Le caméléon", true, animalCouleurQ);
		Reponse animalCouleurB = new Reponse("Le panda", false, animalCouleurQ);
		Reponse animalCouleurC = new Reponse("Le tigre", false, animalCouleurQ);
		Reponse animalCouleurD = new Reponse("L'hippopotame", false, animalCouleurQ);

		Question animalLongeviteQ = new Question("Quel animal a la plus longue espérance de vie ?", animaux);
		Reponse animalLongeviteA = new Reponse("La tortue géante des Galápagos", true, animalLongeviteQ);
		Reponse animalLongeviteB = new Reponse("L'éléphant d'Afrique", false, animalLongeviteQ);
		Reponse animalLongeviteC = new Reponse("Le perroquet ara", false, animalLongeviteQ);
		Reponse animalLongeviteD = new Reponse("Le crocodile", false, animalLongeviteQ);

		Question animalRapideQ = new Question("Quel est l'animal terrestre le plus rapide ?", animaux);
		Reponse animalRapideA = new Reponse("Le guépard", true, animalRapideQ);
		Reponse animalRapideB = new Reponse("Le lion", false, animalRapideQ);
		Reponse animalRapideC = new Reponse("Le cheval", false, animalRapideQ);
		Reponse animalRapideD = new Reponse("L'autruche", false, animalRapideQ);

		// Sauvegarde des questions et réponses pour Animaux
		questionRepo.saveAll(
				Arrays.asList(oiseauVitesseQ, grandMammifereMarinQ, animalCouleurQ, animalLongeviteQ, animalRapideQ));
		reponseRepo.saveAll(Arrays.asList(oiseauA, oiseauB, oiseauC, oiseauD, grandMammifereA, grandMammifereB,
				grandMammifereC, grandMammifereD, animalCouleurA, animalCouleurB, animalCouleurC, animalCouleurD,
				animalLongeviteA, animalLongeviteB, animalLongeviteC, animalLongeviteD, animalRapideA, animalRapideB,
				animalRapideC, animalRapideD));

		// Musique

		Question instrumentBeatlesQ = new Question(
				"Quel instrument de musique George Harrison a-t-il popularisé dans les années 60 ?", musique);
		Reponse beatlesA = new Reponse("La sitar", true, instrumentBeatlesQ);
		Reponse beatlesB = new Reponse("Le synthétiseur", false, instrumentBeatlesQ);
		Reponse beatlesC = new Reponse("La batterie électronique", false, instrumentBeatlesQ);
		Reponse beatlesD = new Reponse("Le theremin", false, instrumentBeatlesQ);

		Question groupeBeatlesQ = new Question("Qui était le manager des Beatles ?", musique);
		Reponse groupeBeatlesA = new Reponse("Brian Epstein", true, groupeBeatlesQ);
		Reponse groupeBeatlesB = new Reponse("George Martin", false, groupeBeatlesQ);
		Reponse groupeBeatlesC = new Reponse("Phil Spector", false, groupeBeatlesQ);
		Reponse groupeBeatlesD = new Reponse("Mick Jagger", false, groupeBeatlesQ);

		Question instrumentMozartQ = new Question("Quel instrument Wolfgang Amadeus Mozart jouait-il principalement ?",
				musique);
		Reponse instrumentMozartA = new Reponse("Le piano", true, instrumentMozartQ);
		Reponse instrumentMozartB = new Reponse("Le violon", false, instrumentMozartQ);
		Reponse instrumentMozartC = new Reponse("La flûte", false, instrumentMozartQ);
		Reponse instrumentMozartD = new Reponse("Le cor", false, instrumentMozartQ);

		Question reinePopQ = new Question("Qui est surnommée la 'Reine de la Pop' ?", musique);
		Reponse reinePopA = new Reponse("Madonna", true, reinePopQ);
		Reponse reinePopB = new Reponse("Lady Gaga", false, reinePopQ);
		Reponse reinePopC = new Reponse("Britney Spears", false, reinePopQ);
		Reponse reinePopD = new Reponse("Whitney Houston", false, reinePopQ);

		Question festivalMusiqueQ = new Question("Où se déroule le festival de Glastonbury ?", musique);
		Reponse festivalMusiqueA = new Reponse("Angleterre", true, festivalMusiqueQ);
		Reponse festivalMusiqueB = new Reponse("États-Unis", false, festivalMusiqueQ);
		Reponse festivalMusiqueC = new Reponse("France", false, festivalMusiqueQ);
		Reponse festivalMusiqueD = new Reponse("Allemagne", false, festivalMusiqueQ);

		Question instrumentJazzQ = new Question(
				"Quel instrument de musique est principalement utilisé pour jouer du jazz ?", musique);
		Reponse jazzA = new Reponse("La guitare", false, instrumentJazzQ);
		Reponse jazzB = new Reponse("Le saxophone", true, instrumentJazzQ);
		Reponse jazzC = new Reponse("Le violon", false, instrumentJazzQ);
		Reponse jazzD = new Reponse("La flûte", false, instrumentJazzQ);

		// Sauvegarde des questions et réponses pour Musique
		questionRepo.saveAll(Arrays.asList(instrumentBeatlesQ, groupeBeatlesQ, instrumentMozartQ, reinePopQ,
				festivalMusiqueQ, instrumentJazzQ));
		reponseRepo.saveAll(Arrays.asList(beatlesA, beatlesB, beatlesC, beatlesD, groupeBeatlesA, groupeBeatlesB,
				groupeBeatlesC, groupeBeatlesD, instrumentMozartA, instrumentMozartB, instrumentMozartC,
				instrumentMozartD, reinePopA, reinePopB, reinePopC, reinePopD, festivalMusiqueA, festivalMusiqueB,
				festivalMusiqueC, festivalMusiqueD, jazzA, jazzB, jazzC, jazzD));

		// Cinéma

		Question oscarActriceQ = new Question("Qui a remporté l'Oscar de la meilleure actrice en 2020 ?", cinema);
		Reponse oscarA = new Reponse("Renée Zellweger", true, oscarActriceQ);
		Reponse oscarB = new Reponse("Scarlett Johansson", false, oscarActriceQ);
		Reponse oscarC = new Reponse("Charlize Theron", false, oscarActriceQ);
		Reponse oscarD = new Reponse("Saoirse Ronan", false, oscarActriceQ);

		Question realisateurInceptionQ = new Question("Qui a réalisé le film 'Inception' ?", cinema);
		Reponse inceptionA = new Reponse("Steven Spielberg", false, realisateurInceptionQ);
		Reponse inceptionB = new Reponse("Christopher Nolan", true, realisateurInceptionQ);
		Reponse inceptionC = new Reponse("Martin Scorsese", false, realisateurInceptionQ);
		Reponse inceptionD = new Reponse("Quentin Tarantino", false, realisateurInceptionQ);

		Question oscarMeilleurFilmQ = new Question("Quel film a remporté l'Oscar du meilleur film en 2020 ?", cinema);
		Reponse oscarMeilleurFilmA = new Reponse("Parasite", true, oscarMeilleurFilmQ);
		Reponse oscarMeilleurFilmB = new Reponse("Joker", false, oscarMeilleurFilmQ);
		Reponse oscarMeilleurFilmC = new Reponse("1917", false, oscarMeilleurFilmQ);
		Reponse oscarMeilleurFilmD = new Reponse("Once Upon a Time... in Hollywood", false, oscarMeilleurFilmQ);

		Question realisateurVertigoQ = new Question("Qui a réalisé le film 'Vertigo' ?", cinema);
		Reponse realisateurVertigoA = new Reponse("Alfred Hitchcock", true, realisateurVertigoQ);
		Reponse realisateurVertigoB = new Reponse("Steven Spielberg", false, realisateurVertigoQ);
		Reponse realisateurVertigoC = new Reponse("Martin Scorsese", false, realisateurVertigoQ);
		Reponse realisateurVertigoD = new Reponse("Quentin Tarantino", false, realisateurVertigoQ);

		Question acteurFightClubQ = new Question("Qui est l'acteur principal dans le film 'Fight Club' ?", cinema);
		Reponse acteurFightClubA = new Reponse("Brad Pitt", true, acteurFightClubQ);
		Reponse acteurFightClubB = new Reponse("Edward Norton", false, acteurFightClubQ);
		Reponse acteurFightClubC = new Reponse("Leonardo DiCaprio", false, acteurFightClubQ);
		Reponse acteurFightClubD = new Reponse("Johnny Depp", false, acteurFightClubQ);

		Question animationDisneyQ = new Question("Quel est le premier long métrage d'animation produit par Disney ?",
				cinema);
		Reponse animationDisneyA = new Reponse("Blanche-Neige et les Sept Nains", true, animationDisneyQ);
		Reponse animationDisneyB = new Reponse("Pinocchio", false, animationDisneyQ);
		Reponse animationDisneyC = new Reponse("Dumbo", false, animationDisneyQ);
		Reponse animationDisneyD = new Reponse("Cendrillon", false, animationDisneyQ);

		// Sauvegarde des questions et réponses pour Cinéma
		questionRepo.saveAll(Arrays.asList(realisateurInceptionQ, oscarActriceQ, oscarMeilleurFilmQ,
				realisateurVertigoQ, acteurFightClubQ, animationDisneyQ));
		reponseRepo.saveAll(Arrays.asList(inceptionA, inceptionB, inceptionC, inceptionD, oscarA, oscarB, oscarC,
				oscarD, oscarMeilleurFilmA, oscarMeilleurFilmB, oscarMeilleurFilmC, oscarMeilleurFilmD,
				realisateurVertigoA, realisateurVertigoB, realisateurVertigoC, realisateurVertigoD, acteurFightClubA,
				acteurFightClubB, acteurFightClubC, acteurFightClubD, animationDisneyA, animationDisneyB,
				animationDisneyC, animationDisneyD));

		// Sport

		Question tennisGrandChelemQ = new Question(
				"Qui a remporté le plus de titres en simple messieurs dans les tournois du Grand Chelem ?", sport);
		Reponse tennisA = new Reponse("Roger Federer", false, tennisGrandChelemQ);
		Reponse tennisB = new Reponse("Rafael Nadal", false, tennisGrandChelemQ);
		Reponse tennisC = new Reponse("Novak Djokovic", true, tennisGrandChelemQ);
		Reponse tennisD = new Reponse("Pete Sampras", false, tennisGrandChelemQ);

		Question superBowl2020Q = new Question("Quelle équipe a remporté le Super Bowl en 2020 ?", sport);
		Reponse superBowlA = new Reponse("Les New England Patriots", false, superBowl2020Q);
		Reponse superBowlB = new Reponse("Les Kansas City Chiefs", true, superBowl2020Q);
		Reponse superBowlC = new Reponse("Les Los Angeles Rams", false, superBowl2020Q);
		Reponse superBowlD = new Reponse("Les San Francisco 49ers", false, superBowl2020Q);

		Question footCoupeMondeQ = new Question("Quelle équipe a remporté la Coupe du Monde de football en 2018 ?",
				sport);
		Reponse footCoupeMondeA = new Reponse("France", true, footCoupeMondeQ);
		Reponse footCoupeMondeB = new Reponse("Brésil", false, footCoupeMondeQ);
		Reponse footCoupeMondeC = new Reponse("Allemagne", false, footCoupeMondeQ);
		Reponse footCoupeMondeD = new Reponse("Argentine", false, footCoupeMondeQ);

		Question tennisWimbledonQ = new Question(
				"Qui détient le record du nombre de titres en simple messieurs à Wimbledon ?", sport);
		Reponse tennisWimbledonA = new Reponse("Roger Federer", true, tennisWimbledonQ);
		Reponse tennisWimbledonB = new Reponse("Rafael Nadal", false, tennisWimbledonQ);
		Reponse tennisWimbledonC = new Reponse("Novak Djokovic", false, tennisWimbledonQ);
		Reponse tennisWimbledonD = new Reponse("Pete Sampras", false, tennisWimbledonQ);

		Question natationRecordQ = new Question("Quelle est la distance du record du monde du 100m nage libre ?",
				sport);
		Reponse natationRecordA = new Reponse("50 mètres", false, natationRecordQ);
		Reponse natationRecordB = new Reponse("100 mètres", true, natationRecordQ);
		Reponse natationRecordC = new Reponse("200 mètres", false, natationRecordQ);
		Reponse natationRecordD = new Reponse("400 mètres", false, natationRecordQ);

		Question athletismeDecathlonQ = new Question("Combien d'épreuves compose le décathlon ?", sport);
		Reponse athletismeDecathlonA = new Reponse("10 épreuves", true, athletismeDecathlonQ);
		Reponse athletismeDecathlonB = new Reponse("8 épreuves", false, athletismeDecathlonQ);
		Reponse athletismeDecathlonC = new Reponse("12 épreuves", false, athletismeDecathlonQ);
		Reponse athletismeDecathlonD = new Reponse("6 épreuves", false, athletismeDecathlonQ);

		// Sauvegarde des questions et réponses pour Sport
		questionRepo.saveAll(Arrays.asList(superBowl2020Q, tennisGrandChelemQ, footCoupeMondeQ, tennisWimbledonQ,
				natationRecordQ, athletismeDecathlonQ));
		reponseRepo.saveAll(Arrays.asList(superBowlA, superBowlB, superBowlC, superBowlD, tennisA, tennisB, tennisC,
				tennisD, footCoupeMondeA, footCoupeMondeB, footCoupeMondeC, footCoupeMondeD, tennisWimbledonA,
				tennisWimbledonB, tennisWimbledonC, tennisWimbledonD, natationRecordA, natationRecordB, natationRecordC,
				natationRecordD, athletismeDecathlonA, athletismeDecathlonB, athletismeDecathlonC,
				athletismeDecathlonD));

		Question serpent = new Question("Quel est le serpent qui n'est pas venimeux ?", animaux);
		Question ariana = new Question("Où est née Ariana Grande ?", musique);
		Question laVieEstBelle = new Question("En quelle année est sorti le film “La vie est belle” ?", cinema);
		Question ballonDOr = new Question("A ce jour, qui a gagné le plus de ballons d'or ?", sport);

		questionRepo.saveAll(Arrays.asList(serpent, ariana, laVieEstBelle, ballonDOr));

		Reponse serpentA = new Reponse("Le mamba noir", false, serpent);
		Reponse serpentB = new Reponse("Le cobra Royal", false, serpent);
		Reponse serpentC = new Reponse("La vipère", true, serpent);
		Reponse serpentD = new Reponse("Le serpent corail", false, serpent);

		reponseRepo.saveAll(Arrays.asList(serpentA, serpentB, serpentC, serpentD));

		Reponse arianaA = new Reponse("Aux Etats Unis", true, ariana);
		Reponse arianaB = new Reponse("En Angleterre", false, ariana);
		Reponse arianaC = new Reponse("En Colombie", false, ariana);
		Reponse arianaD = new Reponse("Au Brésil", false, ariana);

		reponseRepo.saveAll(Arrays.asList(arianaA, arianaB, arianaC, arianaD));

		Reponse laVieEstBelleA = new Reponse("1998", true, laVieEstBelle);
		Reponse laVieEstBelleB = new Reponse("2000", false, laVieEstBelle);
		Reponse laVieEstBelleC = new Reponse("1985", false, laVieEstBelle);
		Reponse laVieEstBelleD = new Reponse("2010", false, laVieEstBelle);

		reponseRepo.saveAll(Arrays.asList(laVieEstBelleA, laVieEstBelleB, laVieEstBelleC, laVieEstBelleD));

		Reponse ballonDOrA = new Reponse("Cristiano RONALDO", false, ballonDOr);
		Reponse ballonDOrB = new Reponse("Michel PLATINI", false, ballonDOr);
		Reponse ballonDOrC = new Reponse("Lionel MESSI", true, ballonDOr);
		Reponse ballonDOrD = new Reponse("Marco VAN BASTEN", false, ballonDOr);

		reponseRepo.saveAll(Arrays.asList(ballonDOrA, ballonDOrB, ballonDOrC, ballonDOrD));

	}

}
