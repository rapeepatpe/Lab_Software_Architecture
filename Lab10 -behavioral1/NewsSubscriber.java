package edu.parinya.softarchdesign.behavioral;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class NewsSubscriber implements Subscriber<News> {
	private SubsSet<Subscriber<? super News>> subscribers = new SubsSet<>();

    @Override
    public void subscribe(Subscriber<? super News> subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber<? super News> subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(News news) {
        for (Subscriber<? super News> subscriber : subscribers) {
            subscriber.onNext(news);
        }
    }
}
