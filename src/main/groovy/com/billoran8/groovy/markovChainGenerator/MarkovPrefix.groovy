package com.billoran8.groovy.markovChainGenerator

class MarkovPrefix {
	public List pref = []
	static final int MULTIPLIER = 3l

	MarkovPrefix(MarkovPrefix p) {
		pref.addAll(p.pref)
	}

	MarkovPrefix(int n, String str) {
		pref = []
		(0..n).each { pref.push(str) }
	}

	public int hashCode() {
		int h = 0

		(0..(pref.size() - 1)).each {
			h = MULTIPLIER * h + pref[it].hashCode()
		}

		return h
	}

	public boolean equals(Object o) {
		MarkovPrefix p = (MarkovPrefix) o

		(0..(pref.size() - 1)).each {
			if (!pref[it].equals(p.pref[it])) {
				return false
			}
		}

		return true
	}
}