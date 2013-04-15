package com.billoran8.groovy.markovChainGenerator

class MarkovChain {
	static final int PREFIX = 1
	static final String DELIMETER = "\n"

	Map statetab = [:]

	MarkovPrefix prefix = new MarkovPrefix(PREFIX, DELIMETER)

	Random rand = new Random()

	def build(String input) throws IOException {

		input = input.replaceAll("\\<.*?>","")
		input = input.replaceAll("\\r\\n|\\r|\\n", " ")

		input.split(' ').each { word -> add(word) }

		add(DELIMETER)
	}

	def add(String word) {
		
		def suf = statetab[prefix]

		if (suf == null) {
			suf = []
			statetab[new MarkovPrefix(prefix)] = suf
		}

		suf.push(word)
		prefix.pref.remove(0)
		prefix.pref.push(word)
	}

	def generate(int numWords) {

		List sentence = []

		prefix = new MarkovPrefix(PREFIX, DELIMETER)

		(0..numWords).each {
			def s = statetab[prefix]

			int r = Math.abs(rand.nextInt()) % s.size()
			String suf = s[r]

			prefix.pref.remove(0)
			prefix.pref.push(suf)

			sentence.push(suf)
		}

		sentence.join(' ')
	}
}
