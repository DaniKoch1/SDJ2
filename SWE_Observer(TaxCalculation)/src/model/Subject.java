package model;
import view.Observer;
public interface Subject {
	public void setView(Observer obs);
	public void notifyObserver();
}
