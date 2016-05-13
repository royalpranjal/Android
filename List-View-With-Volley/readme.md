The list view uses Volley Library to make network calls & parses JSON data & gives back response which is then displayed in the list view.
For the images, ImageLoader is used (handles multiple image requests & there's implementation of Lru Cache for it (other than disk cache 
which is used by volley)). The Lru cache sits in front of the disk cache & a cahce miss makes the thread request go to the disk cache.
NetworkImageView is used which extends the normal image view. The info is loaded on from the URL in the JSON file for this image view.
