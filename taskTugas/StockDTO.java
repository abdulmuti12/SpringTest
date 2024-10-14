@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private Long id;
    private String productName;
    private Integer quantity;
    private String serialNumber;
    private String additionalInfo;
    private String image;
    private String createdBy;
    private String updatedBy;
}
