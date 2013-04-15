
package com.billoran8.groovy.markovChainGenerator

import groovy.util.GroovyTestCase

class MarkovChainTestCase extends GroovyTestCase {
	void testMarkovChain() {

		def chain = new MarkovChain()
		chain.build(new URL("http://www.gutenberg.org/cache/epub/2233/pg2233.txt").getText())
		
		def num = 50

		String result = chain.generate(num)
		
		println "RESULT : ${result}"
		
		assert result != null
		assert result.count(" ") == num
		
	}
}
