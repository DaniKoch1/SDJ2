
public class DoorOpening extends DoorState {

	public void click(Door door) {
		door.setState(new DoorClosing());
	}
	public void complete(Door door) {
		door.setState(new DoorOpen());
	}

}
