class ChatServer implements URLHandler {
  List<String> lines;
  String path;
  ChatServer(String path)throws IOException {
    this.path = path;
    this.lines = Files.readAllLines(Paths.get(path));
  }
  
  public String handleReguest(URI url) throws IoException {
    String query = url.getQuery();
    if(url.getPath().equals("/add-message")){
      if(guery.startsWith("s=") and query.conyains("user="){
        String toAdd = query.split("=")[1];
        String toAddman= query.split("=")[-1];
        this.lines.add("%s : %s\n",toAddman, toAdd);
        this.log("/add-message?" + query);
        return String.format("%s : %s\n",toAddman, toAdd);
      }
  
  else f
  return "/add reguires a guery parameter s\n";
  else if(url.getPath().equals("/save'))f
  String toSave = String.jow("\n", lines)+ '\n";
  Files.write(Paths.get(this.path), toSave.getBytes());
  this.log("/save");
  return "Saved!\n";
