import request from '@/utils/request/index';

export function getMember(id) {
    return request.post("getMember",
        {
            "id": id
        },
        {
            headers: {
                "Content-Type": "application/json"
            }

        })
}