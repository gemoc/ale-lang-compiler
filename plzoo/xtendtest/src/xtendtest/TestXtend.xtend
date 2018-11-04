package xtendtest

class TestXtend {
	def haha() {

		val a = #["1", "2"]

		#["yolo"].filter[it.length > 3].empty

		for (x : #[1, 2, 3]) {
			println(x)
		}

		#[1, 2, 3].get(2)
	}
}
