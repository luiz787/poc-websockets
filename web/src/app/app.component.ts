import { Component, OnDestroy } from '@angular/core';
import { webSocket } from 'rxjs/webSocket';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnDestroy {
  readonly messages: string[] = [];
  wsSubscription: Subscription;

  ngOnDestroy() {
    this.wsSubscription?.unsubscribe();
  }

  setupConnection() {
    this.wsSubscription = webSocket('ws://localhost:8080/name').subscribe(
      (message) => {
        this.messages.push((message as any).description as string);
      }
    );
  }

  triggerMessage() {
    fetch('http://localhost:8080/trigger');
  }
}
