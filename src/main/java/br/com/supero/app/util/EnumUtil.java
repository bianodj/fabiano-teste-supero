package br.com.supero.app.util;

public class EnumUtil {

	public enum Status {
		ACTIVE("A", "Ativo"), 
		INACTIVE("I", "Inativo"), 
		BLOCKED("B", "Bloqueado"), 
		REMOVED("R", "Removido"), 
		FINALIZED("C", "Concluído");

		private final String value;
		private final String label;
		
		private Status(final String value, final String label) {
			this.value = value;
			this.label = label;
		}
		
		public String getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

	}

}
