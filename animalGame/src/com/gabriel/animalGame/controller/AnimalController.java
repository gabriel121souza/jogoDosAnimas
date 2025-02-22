package com.gabriel.animalGame.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.gabriel.animalGame.model.AnimalNode;
import com.gabriel.animalGame.view.AnimalView;

public class AnimalController {
	static AnimalView msg = new AnimalView();

	public static void play(AnimalNode<String> current) {
		while (!current.isFolha()) {
			if (msg.query(current.getDados())) {
				current = current.getEsq();
			} else {
				current = current.getDir();
			}
		}

		if (!msg.query("Eu acho que � " + current.getDados() + ".Estou certo?")) {
			aprender(current);
		} else {
			msg.exitoMensagem();
		}
	}

	public static void aprender(AnimalNode<String> current) {
		String adivinheAnimal;
		String corretoAnimal;
		String novaPergunta;

		adivinheAnimal = current.getDados();
		JFrame frame = new JFrame("Joguinho");

		String nome = msg.desistirMensagem();
		if (nome == null || nome.equals("")) {
			System.exit(0);
		}
		corretoAnimal = nome;
		String pergunta = JOptionPane.showInputDialog(null,
				"Fa�a uma pergunta que diferencie " + corretoAnimal + " do " + adivinheAnimal + ".");
		if (pergunta == null || pergunta.equals("")) {
			System.exit(0);
		}
		novaPergunta = pergunta;

		current.setDados(novaPergunta);
		if (msg.query("A(o) " + corretoAnimal + " " + novaPergunta)) {
			current.setEsq(new AnimalNode<String>(corretoAnimal, null, null));
			current.setDir(new AnimalNode<String>(adivinheAnimal, null, null));
		} else {
			current.setEsq(new AnimalNode<String>(adivinheAnimal, null, null));
			current.setDir(new AnimalNode<String>(corretoAnimal, null, null));
		}
	}

}
