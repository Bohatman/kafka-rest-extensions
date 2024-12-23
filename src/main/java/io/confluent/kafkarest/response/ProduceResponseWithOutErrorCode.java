package io.confluent.kafkarest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.confluent.kafkarest.entities.v3.ProduceResponse;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.Optional;
@Generated("com.google.auto.value.processor.AutoValueProcessor")
final public class ProduceResponseWithOutErrorCode{
    private final Optional<String> message;
    private final Optional<String> clusterId;
    private final Optional<String> topicName;
    private final Integer partitionId;
    private final Long offset;
    private final Optional<Instant> timestamp;
    private final Optional<ProduceResponse.ProduceResponseData> key;
    private final Optional<ProduceResponse.ProduceResponseData> value;

    private ProduceResponseWithOutErrorCode(
            Optional<String> message,
            Optional<String> clusterId,
            Optional<String> topicName,
            @Nullable Integer partitionId,
            @Nullable Long offset,
            Optional<Instant> timestamp,
            Optional<ProduceResponse.ProduceResponseData> key,
            Optional<ProduceResponse.ProduceResponseData> value) {
        this.message = message;
        this.clusterId = clusterId;
        this.topicName = topicName;
        this.partitionId = partitionId;
        this.offset = offset;
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Optional<String> getMessage() {
        return message;
    }

    @JsonProperty("cluster_id")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Optional<String> getClusterId() {
        return clusterId;
    }

    @JsonProperty("topic_name")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Optional<String> getTopicName() {
        return topicName;
    }

    @JsonProperty("partition_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    public Integer getPartitionId() {
        return partitionId;
    }

    @JsonProperty("offset")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    public Long getOffset() {
        return offset;
    }

    @JsonProperty("timestamp")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Optional<Instant> getTimestamp() {
        return timestamp;
    }

    @JsonProperty("key")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Optional<ProduceResponse.ProduceResponseData> getKey() {
        return key;
    }

    @JsonProperty("value")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Optional<ProduceResponse.ProduceResponseData> getValue() {
        return value;
    }
    public static Builder builder() {
        return new Builder();
    }

    static final class Builder {
        private Optional<String> message = Optional.empty();
        private Optional<String> clusterId = Optional.empty();
        private Optional<String> topicName = Optional.empty();
        private Integer partitionId;
        private Long offset;
        private Optional<Instant> timestamp = Optional.empty();
        private Optional<ProduceResponse.ProduceResponseData> key = Optional.empty();
        private Optional<ProduceResponse.ProduceResponseData> value = Optional.empty();
        Builder() {
        }
        public Builder setMessage(Optional<String> message) {
            if (message == null) {
                throw new NullPointerException("Null message");
            }
            this.message = message;
            return this;
        }
        public Builder setMessage(@Nullable String message) {
            this.message = Optional.ofNullable(message);
            return this;
        }
        public Builder setClusterId(Optional<String> clusterId) {
            if (clusterId == null) {
                throw new NullPointerException("Null clusterId");
            }
            this.clusterId = clusterId;
            return this;
        }
        public Builder setClusterId(@Nullable String clusterId) {
            this.clusterId = Optional.ofNullable(clusterId);
            return this;
        }
        public Builder setTopicName(Optional<String> topicName) {
            if (topicName == null) {
                throw new NullPointerException("Null topicName");
            }
            this.topicName = topicName;
            return this;
        }
        public Builder setTopicName(@Nullable String topicName) {
            this.topicName = Optional.ofNullable(topicName);
            return this;
        }
        public Builder setPartitionId(@Nullable Integer partitionId) {
            this.partitionId = partitionId;
            return this;
        }
        public Builder setOffset(@Nullable Long offset) {
            this.offset = offset;
            return this;
        }
        public Builder setTimestamp(Optional<Instant> timestamp) {
            if (timestamp == null) {
                throw new NullPointerException("Null timestamp");
            }
            this.timestamp = timestamp;
            return this;
        }
        public Builder setTimestamp(@Nullable Instant timestamp) {
            this.timestamp = Optional.ofNullable(timestamp);
            return this;
        }
        public Builder setKey(Optional<ProduceResponse.ProduceResponseData> key) {
            if (key == null) {
                throw new NullPointerException("Null key");
            }
            this.key = key;
            return this;
        }

        public Builder setKey(@Nullable ProduceResponse.ProduceResponseData key) {
            this.key = Optional.ofNullable(key);
            return this;
        }
        public Builder setValue(Optional<ProduceResponse.ProduceResponseData> value) {
            if (value == null) {
                throw new NullPointerException("Null value");
            }
            this.value = value;
            return this;
        }
        public Builder setValue(@Nullable ProduceResponse.ProduceResponseData value) {
            this.value = Optional.ofNullable(value);
            return this;
        }
        public ProduceResponseWithOutErrorCode build() {
            String missing = "";
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new ProduceResponseWithOutErrorCode(
                    this.message,
                    this.clusterId,
                    this.topicName,
                    this.partitionId,
                    this.offset,
                    this.timestamp,
                    this.key,
                    this.value);
        }
    }
}
