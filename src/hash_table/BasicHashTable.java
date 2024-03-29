package hash_table;

public class BasicHashTable<X,Y> {

	private class HashEntry<X,Y>{
		private X key;
		private Y value;
		
		public HashEntry(X key, Y value) {
			this.key = key;
			this.value = value;
		}
		
		public X getKey() {
			return key;
		}
		public void setKey(X key) {
			this.key = key;
		}
		public Y getValue() {
			return value;
		}
		public void setValue(Y value) {
			this.value = value;
		}
	}
}
