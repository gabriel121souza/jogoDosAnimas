package com.gabriel.animalGame.dao;

import com.gabriel.animalGame.model.AnimalNode;

public class AnimalDao {
		public static AnimalNode<String> inicioArvore() {
	        AnimalNode<String> raiz;
	        AnimalNode<String> filho;

	        final String ROOT_QUESTION = "O animal vive na �gua?";
	        final String LEFT_QUESTION = "O animal � maior que um gato?";
	        final String RIGHT_QUESTION = "O animal � um roedor?";
	        final String ANIMAL1 = "Tubar�o";
	        final String ANIMAL2 = "Peixe";
	        final String ANIMAL3 = "Rato";
	        final String ANIMAL4 = "Coelho";

	        raiz = new AnimalNode<String>(ROOT_QUESTION, null, null);

	        filho = new AnimalNode<String>(LEFT_QUESTION, null, null);
	        filho.setEsq(new AnimalNode<String>(ANIMAL1, null, null));
	        filho.setDir(new AnimalNode<String>(ANIMAL2, null, null));
	        raiz.setEsq(filho);

	        filho = new AnimalNode<String>(RIGHT_QUESTION, null, null);
	        filho.setEsq(new AnimalNode<String>(ANIMAL3, null, null));
	        filho.setDir(new AnimalNode<String>(ANIMAL4, null, null));
	        raiz.setDir(filho);
	        return raiz;
	    }
	}
