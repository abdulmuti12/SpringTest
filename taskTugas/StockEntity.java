@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;  // Matches id (SERIAL PRIMARY KEY)

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;  // Renamed from nomorSeriBarang

    @Column(name = "additional_info", columnDefinition = "jsonb")
    private String additionalInfo;  // Matches additional_info (JSONB)

    @Column(name = "image")
    private String image;  // Renamed from gambarPath (assuming it stores image or path to the image)

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;  // Matches created_at (TIMESTAMP)

    @Column(name = "created_by", nullable = false)
    private String createdBy;  // Matches created_by

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;  // Matches updated_at (TIMESTAMP)

    @Column(name = "updated_by")
    private String updatedBy;  // Matches updated_by
}
