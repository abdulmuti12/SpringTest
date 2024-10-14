@PostMapping("/uploadImage")
public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
    try {
        if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                    .body("Only JPG and PNG files are allowed");
        }

        // Simpan file atau path ke database
        String filePath = saveFile(file);
        return ResponseEntity.ok(filePath);
    } catch (IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
    }
}

private String saveFile(MultipartFile file) throws IOException {
    Path uploadDir = Paths.get("uploads/");
    if (!Files.exists(uploadDir)) {
        Files.createDirectories(uploadDir);
    }
    String filePath = uploadDir.resolve(file.getOriginalFilename()).toString();
    Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
    return filePath;
}