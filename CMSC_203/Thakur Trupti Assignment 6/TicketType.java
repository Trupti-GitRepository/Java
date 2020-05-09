
public enum TicketType {
	ADUlT("Adult"), CHILD("Child"),EMPLOYEE("Employee"),MOVIEPASS("MoviePass");
	
	private String ticketTypeName;
	
	TicketType(String name) {
		ticketTypeName=name;
	}
	
	public static TicketType getTicktType(String ticketTypeName) {
		for(TicketType t:TicketType.values()) {
			if(t.toString().equalsIgnoreCase(ticketTypeName)) {
				return t;
			}
		}
		return null;
	}

}
