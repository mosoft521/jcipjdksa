//package javaguide.java.newFeatures;
//
//public class OptionalFlatMap {
//    public static void main(String[] args) {
//        int userId = 1;
//
//        // 使用flatMap的代码
//        String cityUsingFlatMap = getUserById(userId)
//                .flatMap(OptionalExample::getAddressByUser)
//                .map(Address::getCity)
//                .orElse("Unknown");
//
//        System.out.println("User's city using flatMap: " + cityUsingFlatMap);
//
//        // 不使用flatMap的代码
//        Optional<Optional<Address>> optionalAddress = getUserById(userId)
//                .map(OptionalExample::getAddressByUser);
//
//        String cityWithoutFlatMap;
//        if (optionalAddress.isPresent()) {
//            Optional<Address> addressOptional = optionalAddress.get();
//            if (addressOptional.isPresent()) {
//                Address address = addressOptional.get();
//                cityWithoutFlatMap = address.getCity();
//            } else {
//                cityWithoutFlatMap = "Unknown";
//            }
//        } else {
//            cityWithoutFlatMap = "Unknown";
//        }
//
//        System.out.println("User's city without flatMap: " + cityWithoutFlatMap);
//    }
//}