package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NegativeResponseStatus {

    boolean status;
    String errorMessage;

}
