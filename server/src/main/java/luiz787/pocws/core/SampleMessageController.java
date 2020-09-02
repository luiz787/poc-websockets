package luiz787.pocws.core;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/trigger")
@RequiredArgsConstructor
@CrossOrigin
public class SampleMessageController {

  private final WsFacade handler;

  @GetMapping
  public ResponseEntity<Void> trigger() throws IOException, InterruptedException {
    Thread.sleep(2000);
    handler.sendMessage(
        new SampleMessage(Status.SUCCESS, "Base enriquecida com sucesso", LocalDateTime.now()));
    return ResponseEntity.noContent().build();
  }
}
